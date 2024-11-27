/**
 * day 6 networking
 *
 *  ---> hello, matthew, this is me --->Will
 * OSI model
 * 1: application layer: top layer, like user interface
 * 2: presentation layer: transforms the data into the form that application layer can render/read
 *          data translation, data encryption and decryption, data compression, data formatting
 * 3:Session layer: establish, terminates, maintenance, coordinates connection between you and me.
 * 4: transport layer: provides acknowledgement of scuccessful data transmission.
 * 5:network layer: in this layer , you can transfer diff size of data sequence from one node to another node.
 *                  routing, and logical address: use IP address to identify devices on the network
 * 6:data link layer: data packets are encoded and decoded into bits and manage data transfer
 * 7: physical layer: this layer converts bits that you transfer in the layer 6 into electrical impulses or radio signals
 *
 * TCP/IP model
 * application layer: HTTP, FTP, SMTP.. provides user interface and protocols in this layer so that application can access networks
 * transport layer: end to end communication between you and me and data transfer management.
 * networking layer: this layer sends packets across the network. in this packets, we can see source ip and destination ip, and mac address
 * network access layers transfer packets between diff hosts
 *
 *
 *
 *terms of  TCP:
 * SYN: used to establish the connection between client and host
 * ACK: let you know the other side that it has received thee SYN
 * ACKnum: next sequence number that receiver expects to receive
 * FIN: to terminate connection
 * seq: keep track how many data is has sent, -> make sure data is deliverd in the correct order
 *
 *  client state                client                      server side             server state
 *  listen                                                                          listen
 *   SYN SENT                   ---SYN = 1 seq = x---->        receive              syn RCVD
 *                      <--ACK =1, SYN=1, Seq=y ACKnum = x+1
 *   ESTAB                   receive      --ACK = 1, ACKnum = y+ 1-> receive        ESTAB
 *
 *   what if the first handshake is lost? -> the client side will resend syn to server side
 *   what if the second handshake is lost? the client will resend SYN and server side will resend SYN-ACK
 *
 *    client state                client                      server side             server state
 *    ESTAB                                                                                 ESTAB
 *     FIN_WAIT_1                     --FIN =1, seq =x--->        receive                 CLOSE_WAIT
 *      FIN_WAIT_2                      <----ACK =1, acknum = X+1
 *                                  ..........server side still can send data
 *                                  ..........
 *                                 <----FIN =1, seq = y ------                             LAST_ACK
 *    TIMED_WAIT                ----> ACK = 1, ACKnum = y+ 1  --->                           CLOSED
 *
 *   change your state from Timed wait to closed, you need wait some time.
 *   what if the first handshake is lost? the client will resend fin
 *   what if the second handshake is lost? resend fin and ack
 *   what if the third handshake is lost? resend fin at the server side
 *   what if the last one handshake is lost? the sever resend fin
 *
 *
 *   what is UDP?
 *   UDP is a communication protocol that you do not need to establish connections. it used for time-sensitive transimission.
 *   process of UDP
 *   1: data prepared
 *   2: datagram is sent to target devices
 *   3: datagram is received
 *   4: data is extracted.
 *
 *   DNS:
 *   enter www.google.com in the search bar -> 123.123.123.123
 *
 *   HTTP:
 *   methods in HTTP: GET, post, put, delete, head.....
 *   headers: provides metadata about the message. content type, content length, server infor.....
 *   status codes: 100- 199, 200-299,300-399,400-499 and 500-599
 *
 *   ***stateless protocol****
 *   means each request from you to a server is treated independently
 *
 *   if you want to make http request message:
 *      request message format: method: get, post, put, delete.. PATH:/user, version of the protocol http1.1
 *      headers
 * what is the response message format looks like
 * version of http http 1.1, status code, status message, header
 *
 *
 *
 * methods
 * get: retrieves data from your resource
 *
 * head: similar to get, but it retrieves only the header info
 *
 * post: create a new resource
 * put: if the resources is exist, then update, if not then create it
 * delete: delete resource
 * patch: update resource partially
 *
 * post vs put vs patch
 *
 * options
 * connect
 * trace
 *
 * status code
 * 100- 199:Informational
 * your request is received and you can continue your process
 * example: 100,101, 102
 *
 *
 * 200-299,success
 * the client's request was successfully received and uderstood and accepted
 * 200, ok
 * 201, created
 * 204: no content.....
 *
 *
 * 300-399,redirection
 * your request is redirected to somewhere else
 * 301: moved permanently
 * 302: found,
 * 304: not modified
 *
 *
 *
 *
 * 400-499: request contains bad syntax or cannot be fulfilled -> client side
 * 404: not found,
 * 400 bad request
 * 409: conflict
 *
 *
 *
 * and 500-599:-> server side. the server failed to fulfill a valid request from you
 * 500: internal server error
 * 503
 * 504 gateway timeout
 *
 *
 * https
 * http + ssl/tls
 * symmetric algorithm: use the same key for both encryption and decryption
 *  generally faster and more efficient than asymmetric algo
 *  AES, DES, 3DES
 *  we use this to encrypt and decrypt large amount of data
 *
 *  asymmetric algorithm: use the diff key for encryption and decryption: public key and private key
 *  RSA ECC
 *  secure  communication and key exchange.
 *
 *  step1: https://www.google.com
 *  you are using https:// to establish a secure connection
 *  step2: the server responds by sending SSL/TLS certificate to you( client side)
 *              this certificate contains some info: server's public key and CA(certificate authority)
 *  step3: client: certificate verification
 *      you verifies the server's has a trusted CA.  is CA signed by a trusted company, is it not expired...
 *
 * step4:
 *   you will generate a pre-master secret. this pre-master secret will be used for generating session key
 *
 * step5:
 *  you will send pre-master key to server side with server's public key
 *  only the server wiht its private key can decrypt
 *
 *  step6:
 *   server and client use pre-master key to generate session key. session key is symmetric key, used to encrypt and decrypt.
 *
 * step 7:
 *   client ready and server ready to send data
 *
 *
 *   cookie and session
 *   session is stored on the server side
 *
 *   cookie is used on the client side
 *
 *
 *
 *
 *
 *
 */
public class day6 {

}
