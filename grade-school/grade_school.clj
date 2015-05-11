(ns grade-school)

(defn add [db student level] (assoc db level (concat (get db level) [student])))

(defn grade [roster level] (or (get roster level) []))

(defn sorted [roster] (into (sorted-map) (into {} (for [[k v] roster] [k (sort v)]))))
