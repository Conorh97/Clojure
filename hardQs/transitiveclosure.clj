;;returns the transitive closure of an inputted set

(ns practice.core
 (:gen-class))

(defn -main

  [& args]

  (defn transitive [s]
    (let [findlinks (fn [pairs i] (into [] (filter #(= (get (get (into [] pairs) i) 0) (get % 1)) pairs)))
          getclosure (fn [pairs start] (map #(assoc % 1 (get start 1)) pairs))
          addpairs (fn [s p] 
                     (loop [sett s pairs p pointer 0]
                       (if (= pointer (count pairs)) 
                        sett 
                        (recur (conj sett (nth pairs pointer)) pairs (+ pointer 1)))))]
      (loop [closure s pointer 0 oramount (count closure)]
        (if (= pointer oramount)
         closure 
         (recur (addpairs closure (getclosure (findlinks closure pointer) (get (into [] closure) pointer))) (+ pointer 1) oramount)))))

  (println (transitive #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}))

)
