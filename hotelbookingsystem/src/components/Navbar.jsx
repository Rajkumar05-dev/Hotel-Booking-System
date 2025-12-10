import React, { useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import { authContext } from "../user/AuthContext";


function Navbar() {
  const { token, user, logOut } = useContext(authContext);
  const navigate = useNavigate();

  const logoutUser = () => {
    logOut();
    navigate("/login"); // Correct redirect
  };

  return (
    <nav className="bg-amber-600 text-black p-5 shadow-md">
      <div className="flex justify-between items-center">
        <h1 className="font-bold text-lg"> Hotel Booking</h1>

        <div className="font-bold text-md">
          <Link to="/" className="px-4 hover:underline">
            Home
          </Link>

          {token ? (
            <>
         
 
             <span className="text-amber-300 font-medium">{user?.name}</span>



             <button className="px-4 hover:underline" onClick={logoutUser}>
                Logout
              </button>

             
            </>
          ) : (
            <>
              <Link to="/register" className="px-4 hover:underline">
                Register
              </Link>
              <Link to="/login" className="px-4 hover:underline">
                Login
              </Link>
            </>
          )}
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
