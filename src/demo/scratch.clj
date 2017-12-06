(ns demo.scratch)

(def ping 10)

(defn increment [n]
  (inc n))

(comment

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
           {:name "Faythe"
            :age 10}
           {:name "Craig"
            :age 2}]})

(def output
  (merge input
         {:group-by-age {10 ["Alice" "Eve" "Faythe"]
                         2 ["Bob" "Craig"]
                         25 ["Charlie"]}}))

(defn add-user-by-age [coll {:keys [name age] :as user}]
  (assoc coll age [name]))

(defn transform [{:keys [users] :as data}]
  (let [group-by-age (reduce add-user-by-age {} users)]
    (assoc data :group-by-age group-by-age)))

(comment

  (= (transform input) output)

  (-> input transform :group-by-age)

)
