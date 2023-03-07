;; see https://ask.clojure.org/index.php/10905/control-transient-deps-that-compiled-assembled-into-uberjar?show=10913#c10913
(require 'clojure.tools.deps.alpha.util.s3-transporter)

(ns build
  (:refer-clojure :exclude [compile])
  (:require #_[babashka.fs :as fs]
            [clojure.tools.build.api :as b]))

(def lib 'net.b12n.viip/viip)

(def class-dir "target/classes")

(def uber-file "target/viip.jar")

(def src-dirs ["src" "resources"])

(def basis (b/create-basis))

(defn uber [_]
  (println "Writing pom")
  (b/write-pom {:class-dir class-dir
                :lib lib
                :version "1.0.0"
                :basis basis
                :src-dirs ["src" "resources"]})
  (b/copy-dir {:src-dirs src-dirs
               :target-dir class-dir})

  (println "Compile sources to classes")
  (b/compile-clj {:basis basis
                  :src-dirs src-dirs
                  :class-dir class-dir
                  :ns-compile '[net.b12n.viip.core]})

  (println "Building uberjar")
  (b/uber {:class-dir class-dir
           :uber-file uber-file
           :basis basis
           :main 'net.b12n.viip.core}))
