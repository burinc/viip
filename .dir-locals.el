:;;{:paths ["src"]
;; :deps  {org.clojure/clojure {:mvn/version "1.10.1"}}
;;
;; :aliases
;; {:dev {}
;;  :test
;;  {:extra-paths ["test"]
;;   :extra-deps
;;   {org.clojure/clojurescript     {:mvn/version "1.10.597"}
;;    lambdaisland/kaocha           {:mvn/version "RELEASE"}
;;    com.lambdaisland/kaocha-cljs  {:mvn/version "1.0.113"}
;;    lambdaisland/kaocha-junit-xml {:mvn/version "RELEASE"}
;;    org.clojure/test.check        {:mvn/version "1.0.0"}}}}}

;; Simple config to make aliases start with Clojure
((nil . ((cider-preferred-build-tool     . clojure-cli)
         (cider-clojure-cli-aliases      . "dev:test")
         (cider-repl-display-help-banner . nil))))
