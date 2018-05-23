# gtdorg

A Clojure library designed to ... well, that part is up to you.

## Development setup

### Once, or every time you switch up configs

Recompile index.android.js files:

    $ re-natal use-android-device avd
    $ re-natal use-figwheel

### Startup emulator with figwheel

- Go into android studio > tools > AVD manager and double click one

or

- Start the simulator programmatically

``` shell
$ cd ~/Library/Android/sdk/tools/`
$ ./bin/avdmanager list avd
$ ./emulator -avd PIXEL_XL_API_26
```

- Start the react native process in the avd

``` shell
$ ./node_modules/.bin/react-native run-android
```

- Start the repl

``` shell
$ lein repl
```

- Start figwheel and cljs repl

``` clojure
user=> (start-figwheel "android")
```

- Profit

## Usage

FIXME

## License

Copyright © 2018 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
