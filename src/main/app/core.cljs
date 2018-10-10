(ns app.core
  (:require-macros [app.macros :as mac])
  (:require [cljs.core.async :as async :refer [put! take! promise-chan]]
            [devtools.core :as devtools]
            [fress.wasm :as wasm-api]
            [cargo.api :as cargo]))

(enable-console-print!)
(devtools/install!)

; (def electron (js/require "electron"))
(def path (js/require "path"))

(def cfg
  {:project-name "demo" ;;required
   :dir (path.join (mac/root) "rust" "demo")
   :target :wasm
   :verbose true
   :release? true
   :rustflags {:allow []}})

(defonce module (atom nil))

(defn p->ch
  "convert promise to nodeback style [?err ?data] yielding promise-chan"
  ([promise](p->ch promise (promise-chan)))
  ([promise c]
   (let []
      (.then promise
        (fn [value] (put! c [nil value]))
        (fn [reason](put! c [reason])))
     c)))

(defn build []
  (js/console.clear)
  (take! (cargo/build-wasm cfg)
    (fn [[err {:keys [buffer]}]]
      (if err
        (cargo/report-error err)
        (take! (p->ch (wasm-api/instantiate buffer))
          (fn [[err Mod :as init-res]]
            (if err
              (js/console.error err)
              (do
                (assert (implements? wasm-api/IFressWasmModule Mod))
                (reset! module Mod)))))))))


(defn echo [any]
   (if-let [Mod @module]
     (binding [fress.reader/*keywordize-keys* false
               fress.writer/*stringify-keys* false]
      (wasm-api/call Mod "echo" any)) ;<-------- (wasm-api/write Mod any)
     (throw (js/Error "missing module"))))




