(ns point-mutations)

(defn hamming-distance [foo, bar]
  (if (= (count foo) (count bar))
  (count
    (remove (fn [[x y]] (= x y))
      (map vector foo bar)))
   nil))
