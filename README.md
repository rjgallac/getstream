
TESTING new

don't need to create a seperate group in getsteam.  Creating an activity is enough to create a feed in its own right.  
A feed is essentially a user.  Users are then connected via follow.


curl --location 'http://localhost:8082/activity' --header 'Content-Type: application/json' --data '{
"message": "first company1 message",
"feedSlug": "newgroup",
"userId": "company1"     
}'

curl --location 'http://localhost:8082/activity' --header 'Content-Type: application/json' --data '{
"message": "first user1 message",
"feedSlug": "newgroup",
"userId": "company1user1"
}'

curl --location 'http://localhost:8082/follow' --header 'Content-Type: application/json' --data '{
"feedSlug": "newgroup",
"userId": "company1",
"followerId": "company1user1"
}'

curl -s --location "http://localhost:8082/feed/newgroup/company1user1/" | jq '.'





