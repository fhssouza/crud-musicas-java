# crud-musicas-java

Atividade avaliativa do módulo de Backend

Nessa atividade, vamos construir um web service RESTful, fazendo um CRUD de
nossas músicas preferidas e comunicando com um banco de dados MongoDB.
Usaremos todos os conceitos vistos das aulas 01 a 08 desse módulo.

1-) Descreva aqui o comando para criação do banco (utilizado no mongosh ou 
compass), que deverá ser chamado tech4music
Resposta: use tech4music

2-) Descreva o comando para criar a coleção musicas e já inserir 3 músicas abaixo:
titulo: Forever
artista: Kiss
album: Hot in the Shade
genero: Rock
anoLancamento: 1989
compositor: Paul Stanley

titulo: Algo parecido
artista: Skank
album: Os três primeiros
genero: Pop
anoLancamento: 2018
compositor: Samuel Rosa

titulo: O que me importa
artista: Marisa Monte
album: Memórias, crônicas e declarações de amor
genero: MPB
anoLancamento: 2000
compositor: Jose de Ribamar Cury

Resposta: db.musicas.insertMany([
{
        "titulo": "Forever",
        "artista": "Kiss",
        "album": "Hot in the Shade",
        "genero": "Rock",
        "anoLancamento": 1989,
        "compositor": "Paul Stanley"
},
{
        "titulo": "Algo Parecido",
        "artista": "Skank",
        "album": "Os três primeiros",
        "genero": "Pop",
        "anoLancamento": 2018,
        "compositor": "Samuel Rosa"
},
{
        "titulo": "o que importa",
        "artista": "Marisa Monte",
        "album": "Memorias cronicas e declarações de amor",
        "genero": "MPB",
        "ano": 2000,
        "compositor": "Jose de Ribamar Cury"
}
])

3-) Crie um projeto no VS Code, utilizando as extensões Spring Web e Spring Data
MongoDB. Crie os pacotes model, repository, service, shared e controller, bem
como as classes necessárias para realizar cada funcionalidade esperada no CRUD:

• model
Musica.java

• repository
MusicaRepository.java

• service
MusicaService.java
MusicaServiceImpl.java

• shared
MusicaDto.java

• controller
MusicaController.java

Faça a implementação, testando sua aplicação através do Postman.

Depois, faça o commit do projeto no Github e encaminhe o link, juntamente com a
resposta dos itens 1 e 2


