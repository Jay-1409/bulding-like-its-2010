const express = require('express');
const cors = require('cors');
const oracledb = require('oracledb');
async function get_connection () {
        const connection = await oracledb.getConnection({user: 'jay', password: 'jay', connectString: 'localhost:1521/XE'});
        return connection ;
}
let connection;
const app = express();
app.use(cors());
app.use(express.json());
app.get('/api/health', (req, res)=>{
    res.json("its healthy!");
});

app.post('/api/create-user', async (req, res)=>{
    const {person_name, person_email} = req.body;
    console.log(person_email);
    try {
        const result = await connection.execute(`INSERT INTO PERSON VALUES (:person_name, :person_email)`, [person_name, person_email],  { autoCommit: true })
        res.json({"message" : "user creater", "user" : person_name, "email" : person_name});
    } catch (error) {
        console.error(error);
        res.status(500).json({"message" : error});
    }
});

app.get('/api/get-users', async (req, res) => {
    res = await connection.execute(`SELECT * FROM PERSON`);
});


async function start() {
    connection = await get_connection();
    const server = app.listen(3123, () => {
        console.log(`API running`);
    });
}

start();