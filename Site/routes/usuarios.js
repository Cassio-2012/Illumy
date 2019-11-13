// não mexa nestas 3 linhas!
var express = require('express');
var router = express.Router();
var banco = require('../app-banco');
// não mexa nessas 3 linhas!

router.get('/', function (req, res, next) {
    res.send('respond with a resource');
});


// CADASTRO

router.post('/cadastrar', (req, res, next)=> {
    
    banco.conectar().then(() => {
        console.log(`Chegou para registro: ${JSON.stringify(req.body)}`);

        var email;
        var senha;
        var telefone;
        var nomeEmpresa;
        var endereco;
        //var cadastro_valido = false;

        
        email = req.body.email; // depois de .body, use o nome (name) do campo em seu formulário de login
        senha = req.body.senha;
        telefone = req.body.telefone; // depois de .body, use o nome (name) do campo em seu formulário de login
        nomeEmpresa = req.body.nomeEmpresa; // depois de .body, use o nome (name) do campo em seu formulário de login
        endereco = req.body.endereco;

        /*if (email == undefined || senha == undefined || telefone == undefined || nomeEmpresa == undefined || endereco == undefined) {
            // coloque a frase de erro que quiser aqui. Ela vai aparecer no formulário de cadastro
            throw new Error(`Dados de cadastro não chegaram completos: ${email} / ${senha}`);
        }
        return banco.sql.query(`select count(*) as contagem from empresa where email = '${email}'`);
    }).then(consulta => {


        if (consulta.recordset[0].contagem >= 1) {
            res.status(400).send(`Já existe usuário com esta email"${email}"`);
            return;

                    
        } else {
            console.log('válido!');
            cadastro_valido = true;
        }

   
    }).catch(err => {

        var erro = `Erro no cadastro: ${err}`;
        console.error(erro);
        res.status(500).send(erro);



    }).finally(() => {
      
        if (cadastro_valido) {*/

        return banco.sql.query(`insert into empresa (email, senha, telefone, nomeEmpresa, endereco) values ('${email}','${senha}','${telefone}','${nomeEmpresa}','${endereco}')`);
    }).then(() => {
        res.send(200);
    }).catch(err => {
        console.log(err);
    }).finally(() => {
        banco.sql.close();
    })
});

router.post('/entrar', (req, res, next)=> {

    banco.conectar().then(() => {
        console.log(`Chegou p/ login: ${JSON.stringify(req.body)}`);
        var email = req.body.email; // depois de .body, use o nome (name) do campo em seu formulário de login
        var senha = req.body.senha; // depois de .body, use o nome (name) do campo em seu formulário de login
        /*if (email == undefined || senha == undefined) {
            throw new Error(`Dados de login não chegaram completos: ${email
                } / ${senha}`);
        }
        return banco.sql.query(`select * from empresa where email='${email}' and senha='${senha}'`);
    }).then(consulta => {

        console.log(`Usuários encontrados: ${JSON.stringify(consulta.recordset)}`);

        if (consulta.recordset.length == 1) {
            res.send(consulta.recordset[0]);
        } else {
            res.sendStatus(404);
        }

    }).catch(err => {

        var erro = `Erro no login: ${err}`;
        console.error(erro);
        res.status(500).send(erro);

    }).finally(() => {
        banco.sql.close();
    });

});*/

        return banco.sql.query(`SELECT * FROM empresa where email = '${email}' and senha='${senha}'`);
    }).then((consulta) => {
        console.log(consulta.recordset);
        if (consulta.recordset.length == 1) {
            res.send(consulta.recordset[0]);
        } else {
            res.sendStatus(404);
        }
    }).catch(err => {
        console.log(err);
    }).finally(() => {
        banco.sql.close();
    })
});

// não mexa nesta linha!
module.exports = router;