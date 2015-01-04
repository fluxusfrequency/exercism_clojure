(ns beer-song
  (require [clojure.string :as str]))

(def verse_part_1 " of beer on the wall, ")
(def verse_part_2 " of beer.\n")
(def verse_part_3 " down and pass it around, ")
(def verse_part_4 " of beer on the wall.\n")

(defn pluralize_count [n]
  (if (= n 0) "no more" n))

(defn pluralize_bottles [n]
  (if (= n 1) " bottle" " bottles"))

(defn one_or_it [n]
  (if (= n 1) "Take it" "Take one"))

(defn next_action [n]
  (if (= n 0) "Go to the store and buy some more, " (str (one_or_it n) verse_part_3)))

(defn wrap [n]
  (if (>= n 1) (dec n) 99))

(defn first_line [n]
  (str (str/capitalize(pluralize_count n))
       (pluralize_bottles n)
        verse_part_1))

(defn second_line [n]
  (str (pluralize_count n)
       (pluralize_bottles n)
        verse_part_2))

(defn third_line [n]
  (str (next_action n)
       (pluralize_count (wrap n))
       (pluralize_bottles (dec n))))

(defn fourth_line [n] verse_part_4)

(defn verse [n]
  (str (first_line n)
       (second_line n)
       (third_line n)
       (fourth_line n)))

(defn sing
  ([start] (sing start 0))

  ([start stop]
    ; There has to be a better way to pop the extra newline than this
    (str(str/trim-newline
        (apply str
          (->>
            (range stop (inc start))
             reverse
            (map #(str (verse %1) "\n"))
          )
        ))
     "\n")))
