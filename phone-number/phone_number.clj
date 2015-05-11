(ns phone-number
  (require [clojure.string :as str]))

(defn number [raw_number]
  (let [parsed (str/replace raw_number #"[\W+]" "")]
    (cond
      (and (= 11 (count parsed)) (= \1 (first parsed)))
        (str/replace-first parsed #"." "")
      (not (= 10 (count parsed)))
        "0000000000"
       :else parsed)))

(defn area-code [raw_number]
  (subs (number raw_number) 0 3))

(defn prefix [raw_number]
  (subs (number raw_number) 3 6))

(defn suffix [raw_number]
  (subs (number raw_number) 6 10))

(defn pretty-print [raw_number]
  (str "(" (area-code raw_number) ") "
       (prefix raw_number) "-" (suffix raw_number)))
