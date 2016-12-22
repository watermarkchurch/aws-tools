package org.watermark.tools.aws;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;

public class Download {

	public static void main(String[] args) {
		/*
         * Create your credentials file at ~/.aws/credentials (C:\Users\USER_NAME\.aws\credentials for Windows users) 
         * and save the following lines after replacing the underlined values with your own.
         *
         * [default]
         * aws_access_key_id = YOUR_ACCESS_KEY_ID
         * aws_secret_access_key = YOUR_SECRET_ACCESS_KEY
         */
		
//		BasicAWSCredentials awsCreds = new BasicAWSCredentials("access_key_id", "secret_key_id");
//		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//		                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//		                        .build();

        AmazonS3 s3 = new AmazonS3Client();
        Region usWest2 = Region.getRegion(Regions.US_WEST_2);
        s3.setRegion(usWest2);

//        String bucketName = "my-first-s3-bucket-" + UUID.randomUUID();
        
        String myKey = "AKIAIKODNZ7PP5SJYVVA";
        String wccKey = "AKIAJKRSX7TZBPLBLQRQ";
        

        System.out.println("===========================================");
        System.out.println("Getting Started with Amazon S3");
        System.out.println("===========================================\n");

        try {
            /*
             * Create a new S3 bucket - Amazon S3 bucket names are globally unique,
             * so once a bucket name has been taken by any user, you can't create
             * another bucket with that same name.
             *
             * You can optionally specify a location for your bucket if you want to
             * keep your data closer to your applications or users.
             */
//            System.out.println("Creating bucket " + bucketName + "\n");
//            s3.createBucket(bucketName);

            /*
             * List the buckets in your account
             */
        	String bucketName = null;
            System.out.println("Listing buckets");
            for (Bucket bucket : s3.listBuckets()) {
                System.out.println(" - " + bucket.getName());
                bucketName = bucket.getName();
            }
            System.out.println();

            /*
             * Upload an object to your bucket - You can easily upload a file to
             * S3, or upload directly an InputStream if you know the length of
             * the data in the stream. You can also specify your own metadata
             * when uploading to S3, which allows you set a variety of options
             * like content-type and content-encoding, plus additional metadata
             * specific to your applications.
             */
//            System.out.println("Uploading a new object to S3 from a file\n");
//            s3.putObject(new PutObjectRequest(bucketName, key, createSampleFile()));

            /*
             * Download an object - When you download an object, you get all of
             * the object's metadata and a stream from which to read the contents.
             * It's important to read the contents of the stream as quickly as
             * possibly since the data is streamed directly from Amazon S3 and your
             * network connection will remain open until you read all the data or
             * close the input stream.
             *
             * GetObjectRequest also supports several other options, including
             * conditional downloading of objects based on modification times,
             * ETags, and selectively downloading a range of an object.
             */
//            System.out.println("Downloading an object");
//            S3Object object = s3.getObject(new GetObjectRequest(bucketName, key));
//            System.out.println("Content-Type: "  + object.getObjectMetadata().getContentType());
//            displayTextInputStream(object.getObjectContent());

            /*
             * List objects in your bucket by prefix - There are many options for
             * listing the objects in your bucket.  Keep in mind that buckets with
             * many objects might truncate their results when listing their objects,
             * so be sure to check if the returned object listing is truncated, and
             * use the AmazonS3.listNextBatchOfObjects(...) operation to retrieve
             * additional results.
             */
//            System.out.println("Listing objects");
//            ObjectListing objectListing = s3.listObjects(new ListObjectsRequest()
//                    .withBucketName(bucketName)
//                    .withPrefix("AKIAIK"));
//            for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
//                System.out.println(" - " + objectSummary.getKey() + "  " +
//                        "(size = " + objectSummary.getSize() + ")");
//            
//                try {
//                	System.out.println("Downloading " + bucketName + "," + objectSummary.getKey() );
//                    S3Object o = s3.getObject(bucketName, objectSummary.getKey());
//                    S3ObjectInputStream s3is = o.getObjectContent();
//                    FileOutputStream fos = new FileOutputStream(new File(objectSummary.getKey()));
//                    byte[] read_buf = new byte[1024];
//                    int read_len = 0;
//                    while ((read_len = s3is.read(read_buf)) > 0) {
//                        fos.write(read_buf, 0, read_len);
//                    }
//                    s3is.close();
//                    fos.close();
//                } catch (AmazonServiceException e) {
//                    System.err.println(e.getErrorMessage());
//                    System.exit(1);
//                } catch (FileNotFoundException e) {
//                    System.err.println(e.getMessage());
//                    System.exit(1);
//                } catch (IOException e) {
//                    System.err.println(e.getMessage());
//                    System.exit(1);
//                }
//                
//            }
//            System.out.println();
            
            
            
//            System.out.println("Listing objects");
//            ObjectListing objectListing = s3.listObjects(new ListObjectsRequest()
//                    .withBucketName(bucketName)
//                    .withPrefix("aws-java-sdk"));
//            for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
//                System.out.println(" - " + objectSummary.getKey() + "  " +
//                        "(size = " + objectSummary.getSize() + ")");
//            }
//            System.out.println();

        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which means your request made it "
                    + "to Amazon S3, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with S3, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }

	}

}
