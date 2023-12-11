AWSCredentials credentials = new BasicAWSCredentials("AKIATPGAT4CNC7RKH5O5", "xayn2YUKx2mZlIYRmtuU3ja3NtmWOlGnENnhMXYs");
			AWSCredentialsProvider awsCredentialsProvider = new StaticCredentialsProvider(credentials);

			AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
					.withRegion("us-east-1")
					.withCredentials(awsCredentialsProvider)
					.build();
			
			DynamoDB dynamoDB = new DynamoDB(client);
			Table table = dynamoDB.getTable("Rules");
			
			Item item=table.getItem("systemTypeId",id);
			logger.info("item ::{}",item.toJSONPretty());


   Exception ::The security token included in the request is invalid. (Service: AmazonDynamoDBv2; Status Code: 400; Error Code: UnrecognizedClientException; Request ID: 4Q77SK80N0GSCK41BL45P6404BVV4KQNSO5AEMVJF66Q9ASUAAJG; Proxy: null)
