# clj-demo

A small Clojure project that only has docker-compose as a dependency.

The purpose of this project is to create a sandbox for experimenting with Clojure via the
repl.

The following two ports are exposed on the host machine:

```
8080 - simple webserver
5080 - clojure nrepl
```

## Usage

```
docker-compose up
```

## Repl connection

In order to connect to the Clojure nrepl, any of the following popular tools may be used.

### Vim
[vim-fireplace](https://github.com/tpope/vim-fireplace)
### Emacs
[cider](https://github.com/clojure-emacs/cider)
### IntelliJ
[cursive](https://cursive-ide.com/)
