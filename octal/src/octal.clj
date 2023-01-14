(ns octal)

(defn oct-char->dec
  "Returns the decimal value of a lowercase octal char."
  [c]
  (- (int c) 48))

(defn oct->dec-values
  "Converts a string that represents a non-negative octal
  number to a seq of the decimal values of its digits."
  [s]
  (map oct-char->dec s))

(defn valid-oct?
  "Returns true if the seq of decimal values represents a valid
  octal number, false otherwise."
  [decimal-values]
  (every? #(<= 0 % 7) decimal-values))

(defn compute-decimal
  "Given a seq of decimal values that represent an octal
  number, it computes the decimal equivalent of that number."
  [decimal-values]
  (+ (last decimal-values)
     (reduce (fn [result digit]
               (* 8 (+ result digit)))
             0
             (butlast decimal-values))))

(defn to-decimal
  "Converts the given octal number (string) to the decimal equivalent.
  Returns 0 if the string does not represent a valid octal number."
  [s]
  (let [dec-values (oct->dec-values s)]
    (if (valid-oct? dec-values)
      (compute-decimal dec-values)
      0)))
