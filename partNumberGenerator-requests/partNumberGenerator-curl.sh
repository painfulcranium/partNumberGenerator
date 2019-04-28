
curl -X GET \
  http://localhost:8080/customer \
  -H 'Postman-Token: e0bc91ca-24d1-4047-a80a-57c8da98481f' \
  -H 'cache-control: no-cache'

--------------------------------------------
curl -X GET \
  http://localhost:8080/customer/2 \
  -H 'Postman-Token: 1cda54b5-9953-4811-997e-f353613f05b6' \
  -H 'cache-control: no-cache'

--------------------------------------------
curl -X GET \
  'http://localhost:8080/partNumber?customerID=1' \
  -H 'Postman-Token: 7953d3ab-ea17-490f-beed-9454f8d2413c' \
  -H 'cache-control: no-cache'


--------------------------------------------
curl -X POST \
  http://localhost:8080/customer/1/partNumber \
  -H 'Postman-Token: 47ae40b6-9b79-46cb-b04a-4641eb002755' \
  -H 'cache-control: no-cache'


--------------------------------------------