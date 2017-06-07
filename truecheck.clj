;;takes a number of parameters and returns true if some are true but not all

(fn [& x] (= (not= (some true? (into [] x)) (some false? (into [] x))) (contains? (into [] x) true)))
