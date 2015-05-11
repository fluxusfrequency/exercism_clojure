(ns nucleotide-count)

(defn add-nucleotide [dict nucleotide]
  (update-in dict [count nucleotide]
    (fnil inc 0)))

(defn count [nucleotide strand]
  (let [split_strand (seq strand)]
    (or (get (frequencies strand) nucleotide) 0)))

(defn nucleotide-counts [strand]
  (let [split_strand (seq strand)]
    (reduce add-nucleotide {\A 0 \T 0 \C 0 \G 0} split_strand)))
