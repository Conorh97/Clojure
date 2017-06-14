;;description in link http://www.4clojure.com/problem/138

(ns practice.core
 (:gen-class))

(defn -main

  [& args]
  
  (defn getdigits [x]
    (loop [vecto x pointer 0 base []]
     (if (= pointer (count vecto))
      (flatten base)
      (recur vecto (+ pointer 1) (conj base (map #(Character/digit % 10) (str (get vecto pointer))))))))

  (defn getsqrs [s e]
    (loop [start s end e sqrs [s]]
      (if (> (* start start) end)
       sqrs
       (recur (* start start) end (conj sqrs (* start start))))))
   
  (defn gendnum [n]
    (loop [nums n pointer 0]
      (if (>= (* pointer pointer) (count nums))
       pointer
       (recur nums (+ pointer 1)))))

  (defn getdnum [x y] (gendnum (getdigits (getsqrs x y))))
  
  (defn getdims [dnum] (- (* dnum dnum) (* (- dnum 1) (- dnum 1))))

  (defn genspace [dim] (vec (repeat dim (into [] (repeat dim " ")))))
 
  (defn genvals [n d]
    (loop [vecto d 
           vcount n 
           pointer 0 
           valvec []]
      (if (= pointer vcount)
       valvec
       (if (>= pointer (count vecto))
        (recur vecto vcount (+ pointer 1) (conj valvec "*"))
        (recur vecto vcount (+ pointer 1) (conj valvec (nth vecto pointer)))))))

  (defn startdex [dnum]
    (if (even? dnum)
     [(- dnum 2) (- dnum 1)]
     [(- dnum 1) (- dnum 1)]))

  (defn changeDir [pos l]
    (cond
     (= l \a) [(+ (get pos 0) 1) (+ (get pos 1) 1)]
     (= l \b) [(+ (get pos 0) 1) (- (get pos 1) 1)]
     (= l \c) [(- (get pos 0) 1) (- (get pos 1) 1)]
     (= l \d) [(- (get pos 0) 1) (+ (get pos 1) 1)]))

  (defn spiral [s e]
    (loop [space (genspace (getdims (getdnum s e)))
           start s
           end e
           pointer 0
           valz (genvals (* (getdnum s e) (getdnum s e)) (getdigits (getsqrs s e)))
           moves [\a \b \c \d]
           mpoint 0
           dircount 2
           changecount 0
           changeby 1
           position (startdex (getdnum s e))]
      (if (= pointer (count valz))
       space
       (if (= mpoint (count moves))
        (recur space start end pointer valz moves 0 dircount changecount changeby position)
        (if (= 0 dircount)
         (recur space start end pointer valz moves mpoint 2 changecount (+ changeby 1) position)
         (if (= changeby changecount)
          (recur space start end pointer valz moves (+ mpoint 1) (- dircount 1) 0 changeby position)
          (recur (assoc space (get position 0) (assoc (get space (get position 0)) (get position 1) (get valz pointer)))
                 start
                 end
                 (+ pointer 1)
                 valz
                 moves
                 mpoint
                 dircount
                 (+ changecount 1)
                 changeby
                 (changeDir position (get moves mpoint)))))))))

  (defn printspiral [s]
    (loop [spirl s pointer 0]
      (println (get spirl pointer))
      (if (= pointer (- (count spirl) 1))
        nil
        (recur spirl (+ pointer 1)))))

  (printspiral (spiral 2 256))

)
