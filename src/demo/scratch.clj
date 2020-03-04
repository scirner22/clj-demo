(ns demo.scratch
  (:require [clojure.data :as data]))

; Iterative Development Workflow!

; Background
;   - Old School: write, compile, run, test
;   - TDD
;   - repl based

; Clojure
;   - dynamically typed
;   - s-expression based - (function arg1 arg2 arg3)

; Model
;                                         -------
; <- vim-fireplace <- nrepl server 5080 --|     |
;                                         | jvm |
; <- ----------------- http server 8080 --|     |
;                                         -------

; :Connect

; cqp

; cpp







































(def ping 10)

(+ 2 (* 5 1))

(defn increment [n]
  (inc n))

(comment

  (def ping2 10)

  (+ 1 2)

  (increment 123)
)

; --------------------

(def input
  {:users [{:name "Bob"
            :age 2}
           {:name "Alice"
            :age 10}
           {:name "Charlie"
            :age 25}
           {:name "Eve"
            :age 10}
           {:name "Craig"
            :age 2}
           {:name "Faythe"
            :age 10}]})

(def output
  (merge input
         {:group-by-age {10 ["Alice" "Eve" "Faythe"]
                         2 ["Bob" "Craig"]
                         25 ["Charlie"]}}))

(defn add-user-by-age [coll {:keys [name age] :as user}]
  (assoc coll age [name]))

(defn transform [{:keys [users] :as data}]
  ; simulate external system call that is slow!
  (Thread/sleep (* 5 1000))

  (let [group-by-age (reduce add-user-by-age {} users)]
    (assoc data :group-by-age group-by-age)))

(comment

  (= (transform input) output)

  (-> input transform :group-by-age)

)
