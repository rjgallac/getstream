feed groups
Company1Alerts
Company2Alerts
users
timeline


curl --location 'http://localhost:8082/user' \
--header 'Content-Type: application/json' \
--data '{
"userId": "Company1User"
}'

curl --location 'http://localhost:8082/user' \
--header 'Content-Type: application/json' \
--data '{
"userId": "Company1AlertUser"
}'

curl --location 'http://localhost:8082/user' \
--header 'Content-Type: application/json' \
--data '{
"userId": "Company2User"
}'

curl --location 'http://localhost:8082/user' \
--header 'Content-Type: application/json' \
--data '{
"userId": "Company2AlertUser"
}'


curl --location 'http://localhost:8082/activity' \
--header 'Content-Type: application/json' \
--data '{
"message": "company1 alert 1",
"feedSlug": "Company1Alerts",
"userId": "Company1AlertUser"
}'

curl --location 'http://localhost:8082/activity' \
--header 'Content-Type: application/json' \
--data '{
"message": "company2 alert 1",
"feedSlug": "Company2Alerts",
"userId": "Company2AlertUser"
}'


curl --location 'http://localhost:8082/activity' \
--header 'Content-Type: application/json' \
--data '{
"message": "company2 alert 1",
"feedSlug": "Company2Alerts",
"userId": "company2Alertuser"
}'

curl --location 'http://localhost:8082/activity' \
--header 'Content-Type: application/json' \
--data '{
"message": "timeline1",
"feedSlug": "timeline",
"userId": "Company2AlertUser"
}'



curl --location 'http://localhost:8082/follow' \
--header 'Content-Type: application/json' \
--data '{
"feedSlug": "Company1Alerts",
"userId": "Company1AlertUser",
"followerId": "Company1User"
}'

curl --location 'http://localhost:8082/follow' \
--header 'Content-Type: application/json' \
--data '{
"feedSlug": "Company2Alerts",
"userId": "Company2AlertUser",
"followerId": "Company2User"
}'

curl -s --location "http://localhost:8082/feed/Company1Alerts/Company1Alert1user/" | jq '.'
curl -s --location "http://localhost:8082/feed/Company1Alerts/Company1User/" | jq '.'

curl -s --location "http://localhost:8082/feed/Company2Alerts/Company2AlertUser/" | jq '.'
curl -s --location "http://localhost:8082/feed/Company2Alerts/Company2User/" | jq '.'


io.getstream.core.exceptions.StreamAPIException: InputException: You can't follow the same feed. Instead of having user:1 follow user:1, consider implementing this as timeline:1 following user:1. (code = 4 status = 400)
at java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:62) ~[na:na]
