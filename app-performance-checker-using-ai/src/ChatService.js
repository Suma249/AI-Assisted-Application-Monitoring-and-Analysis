//import React, { useEffect } from 'react'
import { useState } from 'react'
//import { Button, Form } from 'react-bootstrap'

const ChatService = () => {
    const [question, setQuestion] = useState("");
    const [response, setResponse] = useState("");
    const [queries, setQueries] = useState([]);

    const handleInputChange = (event) => {
        //const { que, value } = event.target
        // const [...x]=event.target
        //console.log("event.target value: "+x)
        // console.log("question: "+question+" value: "+value)
        setQuestion(event.target.value);
    }

    /* useEffect(() => {
         const fetchEmployee = async () => {
             try {
                 const response = await fetch(`http://localhost:8080/ask-ai/{question}`);
                 const data = await response.json();
                 console.log("data fetched is: " + data);
                setResponse(data);
             }
             catch (error) {
                 console.log("error fetching employee details: " + error);
             }
         }
         fetchEmployee();
 
     }, [question]) */

    const handleUpdate = async (event) => {
        event.preventDefault();
        try {
            console.log("question to ask is:" + question)
            const response = await fetch(`http://localhost:8080/api/ask-ai/${question}`)
            const data = await response.json();
            console.log("data recieved is: " + data.status);
            const answer = data.status !== 200 ? "something went wrong, please try again later" : data.answer;
            console.log("answer: " + answer);
            setQueries((prev) => [...prev, { question, answer }]);
            setResponse(answer);
            setQuestion("");
        }
        catch (error) {
            console.log("error updating employee: " + error.message)
        }
    }

    return (
        <>
            <div className='center-form'>
                <h1>Chat History</h1>
                <div className="chat-history">
                    {
                        queries.map(
                            (item, index) => (
                                <div key={index}>
                                    <p><strong>You: </strong>{item.question}</p>
                                    <p><strong>AI: </strong>{item.answer}</p>
                                </div>
                            )
                        )
                    }
                </div>
                <div>
                    <form onSubmit={handleUpdate}>
                        <input
                            type='text'
                            name='question'
                            placeholder='enter ur question on application performance'
                            value={question}
                            onChange={handleInputChange}
                        />
                        <br />
                        <button type="submit">Ask Question</button>
                    </form>
                </div>
            </div>
        </>
    )
}

export default ChatService
