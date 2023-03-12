# net.b12n.viip.core 





## `-main`
``` clojure

(-main & args)
```

<sub>[source](https://github.com/burinc/viip/blob/main/src/net/b12n/viip/core.clj#L390-L393)</sub>
## `cleanup`
``` clojure

(cleanup xhtml-files input-files)
```

<sub>[source](https://github.com/burinc/viip/blob/main/src/net/b12n/viip/core.clj#L317-L327)</sub>
## `create-pdfmarks`
``` clojure

(create-pdfmarks
 &
 [{:keys [title author tags input-files output-file], :or {tags ["pdf" "utility" "printing"], output-file "pdfmarks"}}])
```

<sub>[source](https://github.com/burinc/viip/blob/main/src/net/b12n/viip/core.clj#L131-L142)</sub>
## `map-keys`
``` clojure

(map-keys f m)
```


Given a function and a map, returns the map resulting from applying
  the function to each key.
  e.g. (map-keys name {:a 1 :b 2 :c 3}) ;;=> {"a" 1, "b" 2, "c" 3}
  
<br><sub>[source](https://github.com/burinc/viip/blob/main/src/net/b12n/viip/core.clj#L11-L17)</sub>
## `merge-pdfs`
``` clojure

(merge-pdfs
 &
 [{:keys [gs-binary paper-size input-files pdfmarks output-file],
   :or {gs-binary "gs", paper-size "letter", output-file "merged-pdfs.pdf", pdfmarks "pdfmarks"}}])
```

<sub>[source](https://github.com/burinc/viip/blob/main/src/net/b12n/viip/core.clj#L144-L164)</sub>
## `presets`
<sub>[source](https://github.com/burinc/viip/blob/main/src/net/b12n/viip/core.clj#L229-L234)</sub>
## `transform-keys`
``` clojure

(transform-keys opts)
```


Transform the options arguments

  ;; a) where keys contain `--`
  (transform-keys {"--profile" "dev", "--region" "us-east-one" })
  ;;=> {:profile "dev" :region "us-east-1"}

  ;; b) work with keys that does not have `--` in it
  (transform-keys {"--profile" "dev", "create" "true" })
  ;;=> {:profile "dev" :create "true"} 
<br><sub>[source](https://github.com/burinc/viip/blob/main/src/net/b12n/viip/core.clj#L19-L30)</sub>
## `usage`
<sub>[source](https://github.com/burinc/viip/blob/main/src/net/b12n/viip/core.clj#L166-L227)</sub>
