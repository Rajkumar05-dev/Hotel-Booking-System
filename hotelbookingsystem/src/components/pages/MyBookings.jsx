import React, { useContext, useEffect, useState } from "react";
import { authContext } from "../../user/AuthContext";

function MyBookings() {
  const { token, user } = useContext(authContext);
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    if (!user?.id || !token) return;

    fetch(`http://localhost:8080/bookings/user/${user.id}`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
      .then((res) => res.json())
      .then((data) => setBookings(data))
      .catch((err) => console.log(err));
  }, [user?.id, token]);

  return (
    <div className="p-6 min-h-screen bg-gray-100 font-sans">
      <h1 className="text-3xl font-bold text-blue-600 mb-5">My Bookings</h1>

      <div className="space-y-4">
        {bookings.length === 0 && (
          <p className="text-gray-600">No bookings found.</p>
        )}

        {bookings.map((b) => (
          <div key={b.id} className="bg-white p-4 shadow rounded-lg">
            <p>
              <span className="font-medium">Hotel:</span> {b.room?.hotel?.id}
            </p>
            <p>
              <span className="font-medium">Room:</span> {b.room?.roomNumber || "N/A"}
            </p>
            <p>
              <span className="font-medium">Check-in:</span> {b.checkInDate || "N/A"}
            </p>
            <p>
              <span className="font-medium">Check-out:</span> {b.checkOutDate || "N/A"}
            </p>
            <p>
              <span className="font-medium">Total Price:</span> ₹{b.totalPrice || "N/A"}
            </p>
            <p>
              <span className="font-medium">Status:</span> {b.status || "N/A"}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default MyBookings;
