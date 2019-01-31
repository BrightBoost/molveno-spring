INSERT INTO Roomtype (roomtype , roomprice ) VALUES ('Luxury',139.99);
INSERT INTO Roomtype (roomtype , roomprice ) VALUES ('Standard',99.99);
INSERT INTO Roomtype (roomtype , roomprice ) VALUES ('Budget',79.99);

INSERT INTO Guest (firstname , lastname , email,phone,password,street,postcode,country,housenumber ) VALUES ('Mohamad','Aez','mohamad@gmail.com','087776','2222','kees','1096MS','Nederland','666');
INSERT INTO Guest (firstname , lastname , email,phone,password,street,postcode,country,housenumber ) VALUES ('Mohamads','Aezs','mohamassd@gmail.com','087776','2222','kesaes','1096MS','Nederland','6as66');
INSERT INTO Guest (firstname , lastname , email,phone,password,street,postcode,country,housenumber ) VALUES ('Mohasdamad','Aessaz','mohassmad@gmasail.com','087776','2222','keases','109as6MS','Nedeasrland','666');

INSERT INTO Room (roomtypeid,roomname,roomava) VALUES ('1','room1','true');
INSERT INTO Booking(guestid,checkin,checkout) VALUES ('1',parseDateTime('20190520','yyyyMMdd'),parseDateTime('20190525','yyyyMMdd'));
INSERT INTO roombooking(bookingid,roomid) VALUES ('1','1')