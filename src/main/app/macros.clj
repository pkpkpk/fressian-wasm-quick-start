(ns app.macros
  (:require [cljs.env :as env]
            [cljs.analyzer :as ana]
            [cljs.analyzer.api :as ana-api]
            [cljs.util :as util]
            [clojure.java.io :as io]
            [clojure.edn :as edn]))

(defmacro root
  "get project-root of caller. This makes things friendly for 'checkout' compilations"
  []
  (let [caller-file (io/file ana/*cljs-file*)]
    (loop [f caller-file]
      (if (= "src" (.getName f))
        (if-let [root (.getParentFile f)]
          (.getPath root)
          (System/getProperty "user.dir"))
        (recur (.getParentFile f))))))