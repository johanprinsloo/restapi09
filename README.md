Unfiltered based restful web API
--------------------------------

Run
---
Build with the simple build tool sbt -> update -> run

Exercise
--------
curl http://127.0.0.1:8080/optimizer/my+file

echo "optimizer input 101" | curl -i http://127.0.0.1:8080/optimizer/my+file -T -

curl http://127.0.0.1:8080/optimizer/my+file
