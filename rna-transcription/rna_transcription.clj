(ns rna-transcription)

(def ^:private conversions {
  \C \G
  \G \C
  \A \U
  \T \A
})

(defn valid? [strand]
  (re-matches #"[CGAT]+" strand))

(defn convert-nucleotide [nucleotide]
  (get conversions nucleotide))

(defn to-rna [strand]
  {:pre [(valid? strand)]}
  (clojure.string/join
    (map
      (fn [^Character c] (convert-nucleotide c)
    ) strand)
  )
)
