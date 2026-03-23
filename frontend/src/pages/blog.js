import { useEffect, useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import api from "../services/api";

function Blog() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    api.get("/posts")
      .then(res => {
        console.log(res.data);
        setPosts(res.data);
      })
      .catch(err => {
  console.error("ERRO COMPLETO:", err);
});
  }, []);

  return (
    <div className="container mt-4">
      <h1>Artigos do Blog</h1>

      {posts.map((post, i) => (
        <div key={i} className="card mb-3 p-3">
          <h2>{post.titulo}</h2>
          <p><strong>Data:</strong> {post.data}</p>

          <div
            dangerouslySetInnerHTML={{ __html: post.conteudo }}
          />
        </div>
      ))}
    </div>
  );
}

export default Blog;
