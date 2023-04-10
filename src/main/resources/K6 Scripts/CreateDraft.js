import http from "k6/http";
import { check } from "k6";

export const options={
	executor:'per-vu-iterations',
	vus:10,
	iterations:200,
	maxDuration: '30s',
}
export default function () {
  let url = "http://localhost:8080/api/tasks/createProduct";
  
  let payload = JSON.stringify({
    "productname":"Phone",
    "productdesc":"Apple iphone"
  });
  
  let params = {
    headers: {
      "Content-Type": "application/json",
    }
  };

  let res = http.post(url, payload, params);
  
  check(res, {
    "status is 200": (r) => r.status === 200,
	
  });
}
