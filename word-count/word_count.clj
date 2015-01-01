(ns word-count
  (require [clojure.string :as str]))

(defn add-word [dict word]
  (update-in dict [word]
    (fnil inc 0)))

(defn word-count [words]
  (reduce add-word {} (re-seq #"\w+" (str/lower-case words))))
