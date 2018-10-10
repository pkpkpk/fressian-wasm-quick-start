# fressian-wasm-quick-start

```bash
$ npm install
$ clj -A:build-dev
```

Once it has fired up..

```clojure
(in-ns 'app.core)

(build)

;; let rust compile the demo app

(echo ["hello" "wasm"]) ;=> [nil ["hello" "wasm"]]
```

## fressian-wasm

  + [fress][fress]
  + [serde-fressian][serde-fressian]
  + [cargo-cljs][cargo-cljs]

### electron

This repo is basically the [electron quick start][ele-quick-start] with figwheel pasted in.




[fress]: https://github.com/pkpkpk/fress
[serde-fressian]: https://github.com/pkpkpk/serde-fressian
[cargo-cljs]: https://github.com/pkpkpk/cargo-cljs
[ele-quick-start]: https://github.com/electron/electron-quick-start

