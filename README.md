# ProvaSoftdesign

Mapa de relacionamentos

Associado possui 0 ou mais Assembleia    
Assembleia possui 1 ou mais Associado 

Assembleia possui 0 ou mais Pauta
Pauta possui 1 ou mais Assembleia

Associado possui 0 ou mais Votacoe
Votacoe possui 0 ou mais Associado

Pauta possui 0 ou mais Votacoe 
Votacoe possui 0 e apenas 1 Pauta

Associado {

id:String
nome:String
cpf:String
rg:int
dataNasci:Data

}

Assembleia {

id:String
nome:String
assunto:String
dataInicio:Data
duracao:String

}

Pauta {

id:String
nome:String
assunto:String

}

Votacao{

id:String
resultado:booleon
tempoVotacao:Double

}



1 - Criar CRUD básico do Associado
2 - Criar CRUD básico da Assembleia
3 - Criar CRUD básico da Pauta
4 - Criar CRUD básico da Votacao
5 - Criar Relacionamentos dos documentos

