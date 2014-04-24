(defproject swift-one-liner "0.1.0-SNAPSHOT"
  :description "A one-liner to start a thrift server using swift"
  :url "http://example.com/FIXME"
  :license {:name "Do What the Fuck You Want to Public License"
            :url "http://www.wtfpl.net"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.facebook.swift/swift-codec "0.12.0"]
                 [com.facebook.swift/swift-service "0.12.0"]]
  :repositories [["sonatype" {:url "http://oss.sonatype.org/content/repositories/releases"}]]
  :java-source-paths ["src"])
