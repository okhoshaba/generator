from http.server import BaseHTTPRequestHandler, HTTPServer
import time

#hostName = "localhost"
hostName = "192.168.1.108"
hostPort = 9000

class MyServer(BaseHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200)
        self.send_header("Content-type", "text/html".encode())
        self.end_headers()
        self.wfile.write("Test Agent !".encode())

myServer = HTTPServer((hostName, hostPort), MyServer)
print(time.asctime(), "Test Agent Starts - %s:%s" % (hostName, hostPort))

try:
    myServer.serve_forever()
except KeyboardInterrupt:
    pass

myServer.server_close()
print(time.asctime(), "Test Agent Stops - %s:%s" % (hostName, hostPort))

