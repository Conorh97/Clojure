;;returns the best possible poker hand out of 5 cards

(ns practice.core
 (:gen-class))

(defn -main

  [& args]
  
  (defn group [c i]
    (loop [cards c 
           indx i 
           pointer 0 
           base []]
      (if (= pointer (count cards))
       base
       (recur cards indx (+ pointer 1) (conj base (get (into [] (get cards pointer)) indx)))))) 
  
  (defn isPresent [cards number] (= number (some #{number} (into [] (vals (frequencies (group cards 1)))))))

  (defn sortVals [cards]
    (loop [nums (group cards 1)
           pointer 0
           newvec []
           lvals {\A 14, \K 13, \Q 12, \J 11, \T 10, \9 9, \8 8, \7 7, \6 6, \5 5, \4 4, \3 3, \2 2}]
      (if (= pointer (count nums))
       (sort newvec)
       (recur nums (+ pointer 1) (conj newvec (get lvals (get nums pointer))) lvals))))
  
  (defn straight [cards] (and (= (- (last (sortVals cards)) (first (sortVals cards))) 4) (= (count (frequencies (group cards 1))) 5)))

  (defn fluush [cards] (apply = (group cards 0)))

  (defn sflush [cards] (and (straight cards) (fluush cards)))

  (defn four-of-a-kind [cards] (isPresent cards 4))

  (defn full-house [cards] (and (isPresent cards 3) (isPresent cards 2)))

  (defn three-of-a-kind [cards] (isPresent cards 3))

  (defn two-pair [cards] (= 2 (some #{2} (into [] (vals (frequencies (into [] (vals (frequencies (group cards 1))))))))))

  (defn pair [cards] (isPresent cards 2))

  (defn highest [cards]
    (cond
     (sflush cards) :straight-flush
     (four-of-a-kind cards) :four-of-a-kind
     (full-house cards) :full-house
     (fluush cards) :fluush
     (straight cards) :straight
     (three-of-a-kind cards) :three-of-a-kind
     (two-pair cards) :two-pair
     (pair cards) :pair
     :else :high-card))

  (println (highest ["H7" "Q8" "Q9" "HJ" "HT"]))

)
