import http from "k6/http";
import { check } from "k6";

export const options={
	executor:'per-vu-iterations',
	vus:10,
	iterations:200,
	maxDuration: '30s',
}
export default function () {
  let url = "http://localhost:8080/api/tasks/666/dealerEdit";
 
  let params = {
    headers: {
      "Content-Type": "application/json",
    }
  };

  let res = http.post(url, params);

  check(res, {
    "status is 200": (r) => r.status === 200,
  });
}
