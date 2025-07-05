import React, {useEffect, useState} from "react";
import axios from 'axios';
import { Link } from "react-router-dom";

function Posts() {
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/posts')
        .then(response => {
            setPosts(response.data);
        })
        .catch(error => {
            console.error("Erro ao buscar posts:", error);
        });
        

    }, []);

    return (
        <div style={styles.all_content}>
            <h1>Artigos do Blog</h1>
            {posts.map((post, index) => (
                <div key={index} style={styles.card}>
                    <h2>{post.titulo}</h2>
                    <p><strong>Data:</strong> {formatarData(post.data)}</p>
                    <p><strong>Criado por:</strong> {post.criadoPor}</p>
                    <p><strong>Editado por:</strong> {post.editadoPor}</p>
                    <Link to={`/post/${post.id}`} style={styles.button}>Ler Mais</Link>
                    <hr />
                
                </div>
            ))}
        </div>
    );
}

function formatarData(dataISO) {
  const data = new Date(dataISO);
  return new Intl.DateTimeFormat('pt-BR').format(data);
}

const styles = {
  all_content: {
    display: 'flex',
    alignItems: 'center',
    flexDirection: 'column'

  },

  container: {
    display: 'flex',
    alignItems: 'center',
    padding: '20px',
    backgroundColor: '#f5f5f5',
    minHeight: '100vh',
    fontFamily: 'Arial, sans-serif'
  },
  title: {
    textAlign: 'center',
    marginBottom: '30px',
    color: '#333'
  },
  card: {
    backgroundColor: '#DCD093',
    padding: '50px',
    borderRadius: '12px',
    boxShadow: '0 2px 8px rgba(0,0,0,0.1)',
    marginBottom: '20px',
    justifyContent: 'center',
    alignItems: 'center',
    width: '50%',
    
  },
  button: {
    display: 'inline-block',
    padding: '10px 20px',
    backgroundColor: '#0070f3',
    color: '#fff',
    borderRadius: '8px',
    textDecoration: 'none',
    marginTop: '10px'
  }
};

export default Posts;