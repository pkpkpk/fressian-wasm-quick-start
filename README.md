# fressian-wasm-quick-start


### Setup Rust

1) [Install Cargo](https://doc.rust-lang.org/cargo/getting-started/installation.html)

2) Install the wasm toolchain

``` bash
$ rustup default nightly
$ rustup update
$ rustup component add wasm32-unknown-unknown --toolchain nightly
$ cargo install --git https://github.com/alexcrichton/wasm-gc
```

Run `$rustup update` periodically to update the toolchain.

See [cargo-cljs][cargo-cljs] for more details.

### Install and run the app

```bash
$ npm install
$ clj -A:build-dev
```

Once it has fired up..

```clojure
(in-ns 'app.core)

(build)

;; ...wait while rust compiles the demo app. Devtools should give you pretty green message when it's ready.

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

