;;finds a way through a sample maze

(ns practice.core
 (:gen-class))

(defn -main

  [& args]
  (defn getIndex [x s]
   (loop [maze x 
          letter s 
          row 0]
    (if (= row (count maze))
     nil
     (if (not= (.indexOf (into [] (nth maze row)) letter) -1)
      [row (.indexOf (into [] (nth maze row)) letter)]
      (recur maze letter (+ row 1))))))

  (defn valAt [maze square]
   (if (or (or (< (nth square 0) 0) (> (nth square 0) (count maze))) (or (< (nth square 1) 0) (> (nth square 1) (count (get maze 0)))))
    nil
    (nth (get maze (nth square 0)) (nth square 1))))

  (defn getRows [x] (count x))
  (defn getColumns [x] (count (get x 0)))

  (defn inMaze [x s] (and (and (>= (get s 0) 0) (< (get s 0) (getRows x))) (and (>= (get s 1) 0) (< (get s 1) (getColumns x)))))

  (defn isSeen [s m] (contains? (get m \M) s))
 
  (defn moveUp [s] [(+ (get s 0) 1) (get s 1)])
  (defn moveDown [s] [(- (get s 0) 1) (get s 1)])
  (defn moveLeft [s] [(get s 0) (- (get s 1) 1)])
  (defn moveRight [s] [(get s 0) (+ (get s 1) 1)])

  (defn findPath [x mc m c s]
   (loop [maze x 
          movecount mc 
          mouse m 
          cheese c 
          seen s]
    (if (or (> movecount (* (getRows x) (getColumns x))) (= (isSeen mouse seen) true))
     false
     (if (or (= (valAt maze mouse) \#) (= (inMaze maze mouse) false))
      false
      (if (= mouse cheese)
       true
       (or (or (findPath maze (+ movecount 1) (moveUp mouse) cheese (assoc seen \M (conj mouse (get seen \M))))
       (findPath maze (+ movecount 1) (moveDown mouse) cheese (assoc seen \M (conj mouse (get seen \M)))))
       (or (findPath maze (+ movecount 1) (moveRight mouse) cheese (assoc seen \M (conj mouse (get seen \M))))
       (findPath maze (+ movecount 1) (moveLeft mouse) cheese (assoc seen \M (conj mouse (get seen \M)))))))))))

  (defn callPath [x] (findPath x 0 (getIndex x \M) (getIndex x \C) {\M []}))

  (println (callPath ["M   C"]))

)
