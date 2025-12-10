import React from "react";
import { useContext } from "react";
import { useForm } from "react-hook-form";
import { authContext } from "../../user/AuthContext";

function Login() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const { loginUser } = useContext(authContext)
    const onSubmit = (data) => {
    console.log(data);
    fetch("http://localhost:8080/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "Application/json",
      },
      body: JSON.stringify(data),
    })
      .then((Response) => Response.json())
      .then((responseData) => {
        loginUser(responseData.token,responseData.userDto)
      });
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-100 p-6">
      <div className="bg-white shadow-2xl rounded-2xl overflow-hidden max-w-5xl w-full flex flex-col md:flex-row">
        <div className="hidden md:block md:w-1/2">
          <img
            src="https://plus.unsplash.com/premium_photo-1661883964999-c1bcb57a7357?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjgzfHxsdXh1cnklMjBob3RlbHxlbnwwfHwwfHx8MA%3D%3D"
            alt="Hotel"
            className="h-full w-full object-cover"
          />
        </div>
        <div className="md:w-1/2 w-full p-8 md:p-12 animate-slideIn">
          <h2 className="text-3xl font-bold text-blue-600 text-center mb-6 animate-fadeIn">
            Login
          </h2>
          <form
            className="space-y-5 animate-fadeIn delay-200"
            onSubmit={handleSubmit(onSubmit)}
          >
            <div>
              <label className="block text-sm font-medium text-gray-700 mb-1">
                Email Address
              </label>
              <input
                type="email"
                placeholder="Enter your email"
                className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
                {...register("email", {
                  required: "Email is required",
                })}
              />
              <div id="emailHelp" className="form-text">
                {errors.email && errors.email.message}
              </div>
            </div>
            <div>
              <label className="block text-sm font-medium text-gray-700 mb-1">
                Password
              </label>
              <input
                type="password"
                placeholder="Enter password"
                className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
                {...register("password", {
                  required: "Password is required",
                })}
              />
              <div id="emailHelp" className="form-text">
                {errors.password && errors.password.message}
              </div>
            </div>
            <button
              type="submit"
              className="w-full bg-blue-600 text-white py-2 rounded-lg font-semibold hover:bg-blue-700 duration-200"
            >
              Login
            </button>
            <p className="text-center text-sm">
              Don’t have an account?{" "}
              <a href="#" className="text-blue-600 font-medium hover:underline">
                Register
              </a>
            </p>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Login;
