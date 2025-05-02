import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import App2 from "./App2.jsx";
import App3 from "./App3.jsx";
import App4 from "./App4.jsx";
// 按鈕的寫法
import App5 from "./App5.jsx";
//陣列
import App6 from "./App6.jsx";
//物件陣列
import App7 from "./App7.jsx";
//物件陣列+table
import App8 from "./App8.jsx";
//父組件與子組件應用
import App9 from "./App9.jsx";
//父組件與子組件應用
import App10 from "./App10.jsx";
import "./index.css";

ReactDOM.createRoot(document.getElementById("root")).render(
  // React.StrictMode嚴格模式 代表app會渲染兩次
  <React.StrictMode>
    {/* <App />
    <App2 />
    <App3 />
    <App4 /> 
    <App5 />
    <App6 />
    <App7 />
    <App8 />*/}
    <App9 />
    <App10 />
  </React.StrictMode>
);
