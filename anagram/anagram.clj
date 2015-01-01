(ns anagram
  (require [clojure.string :as str]))

(defn anagrams-for [word candidates]
  (filter (fn [chosen]
    (not
      (= (str/lower-case chosen) (str/lower-case word))))
    (filter (fn [candidate]
      (= (sort (str/lower-case word)) (sort (str/lower-case candidate))))
      candidates)))
