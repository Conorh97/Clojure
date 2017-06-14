;; returns all sets of anagrams in a vector 

(ns practice.core
 (:gen-class))

(defn -main

  [& args]

  (defn anagrams [w]
    (let [comparewords (fn [words i] (into #{} (filter #(= (sort (get words i)) (sort %)) words)))]
      (loop [words w pointer 0 grams #{}]
        (if (= pointer (count words))
         grams
         (if (> (count (comparewords words pointer)) 1)
           (recur words (+ pointer 1) (conj grams (comparewords words pointer)))
           (recur words (+ pointer 1) grams))))))

  (println (anagrams ["beat" "meat" "team" "bate"]))

)
