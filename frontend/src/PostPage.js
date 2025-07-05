import React, {useEffect, useState} from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

function PostPage() {
    const {id} = useParams();
    const [post, setPost] = useState(null);

    useEffect(() => {
        axios.get(`http://localhost:8080/posts/${id}`)
        .then(Response => {
            setPost(Response.data);
        })
        .catch(error => {
            console.error('Erro ao buscar o post', error);
        });
    }, [id]);

    if (!post) {
        return <div>Carregando...</div>
    }

    return (
        <div style={styles.container}>
            <h1>{post.titulo}</h1>
            <p><strong>Data:</strong> {formatarData(post.data)}</p>
            <p><strong>Criado por:</strong> {post.criadoPor}</p>
            <p><strong>Editado por:</strong> {post.editadoPor}</p>

            <div style={styles.content} dangerouslySetInnerHTML={{ __html: post.conteudo}} />

        </div>
    );

}

function formatarData(dataISO) {
  const data = new Date(dataISO);
  return new Intl.DateTimeFormat('pt-BR').format(data);
}

const styles = {
  container: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    padding: '20px',
    margin: '0 auto',
    fontFamily: 'Arial, sans-serif',
    minHeight: '100vh',
  },

  content: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    marginTop: '20px',
    backgroundColor: '#f9f9f9',
    padding: '15px',
    borderRadius: '8px',
    width: '50%',
  },
};

export default PostPage;