(ns phrase
  (require [clojure.string :as str]))

(defn taciturn? [phrase] (str/blank? phrase))

(defn askance? [phrase] (= \? (last phrase)))

(defn holler? [phrase] (and (= phrase (str/upper-case phrase)) (re-find #"[a-zA-Z]" phrase)))



(ns bob)

(defn response-for [input]
  (condp apply [input]
    phrase/taciturn? "Fine. Be that way!"
    phrase/holler? "Whoa, chill out!"
    phrase/askance? "Sure."
    "Whatever."))
