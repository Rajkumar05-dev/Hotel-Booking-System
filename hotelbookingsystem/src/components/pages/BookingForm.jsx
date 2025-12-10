// src/components/rooms/BookingForm.jsx
import React, { useContext } from "react";
import { useForm } from "react-hook-form";
import { useParams, useNavigate } from "react-router-dom";
import { authContext } from "../../user/AuthContext";

function BookingForm() {
  const { token, user } = useContext(authContext);
  const { roomId } = useParams();
  const navigate = useNavigate();
  const { register, handleSubmit } = useForm();

  const onSubmit = (data) => {
    const bookingData = {
      roomId: roomId,
      userId: user.id,
      checkInDate: data.checkInDate,
      checkOutDate: data.checkOutDate,
      totalPrice: data.totalPrice,
      status: "PENDING",
    };

    fetch("http://localhost:8080/bookings", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify(bookingData),
    })
      .then((res) => res.json())
      .then(() => navigate("/mybookings"))
      .catch((err) => console.log(err));
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-100 p-4">
      <div className="bg-white shadow-xl rounded-xl p-8 w-full max-w-lg">
        <h2 className="text-3xl font-bold text-center mb-6 text-blue-600">
          Book Room
        </h2>
        <form className="space-y-4" onSubmit={handleSubmit(onSubmit)}>
          <div>
            <label className="block mb-1 font-medium">Check-in Date</label>
            <input
              type="date"
              className="w-full border px-4 py-2 rounded"
              {...register("checkInDate")}
              required
            />
          </div>
          <div>
            <label className="block mb-1 font-medium">Check-out Date</label>
            <input
              type="date"
              className="w-full border px-4 py-2 rounded"
              {...register("checkOutDate")}
              required
            />
          </div>
          <div>
            <label className="block mb-1 font-medium">Total Price</label>
            <input
              type="number"
              className="w-full border px-4 py-2 rounded"
              {...register("totalPrice")}
              required
            />
          </div>
          <button
            type="submit"
            className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700 font-medium"
          >
            Book Now
          </button>
        </form>
      </div>
    </div>
  );
}

export default BookingForm;
