# Mobilis


**Cauan Augusto Morais Sao Jose, camsjose@sga.pucminas.br**

**Davi Augusto Dias Soares, dadsoares@sga.pucminas.br**

**Miguel Amaral Lessa Xavier, malxavier@sga.pucminas.br**

**Victor Lucas Tornelli, victor.tornelli@sga.puinas.br**

---

Professores:

**Aline Norberta de Brito**

**Eveline Alonso Veloso**

---

_Curso de Engenharia de Software

_Instituto de Informática e Ciências Exatas – Pontifícia Universidade Católica de Minas Gerais (PUC MINAS), Belo Horizonte – MG – Brasil_

---

O trabalho propõe um sistema de acompanhamento de exercícios físicos entre profissionais de saúde e pacientes. O processo inicia com a composição da ficha de exercícios pelo profissional, explicando a seleção de cada atividade. O paciente analisa a lista e dá retorno sobre sua viabilidade. O acompanhamento ocorre durante a execução da ficha, permitindo ao fisioterapeuta verificar se o paciente cumpre as atividades. O paciente pode solicitar ajuda via mensagem para esclarecer dúvidas sobre os exercícios. Ao final, o profissional fornece feedback sobre a necessidade de novos exercícios ou a melhora do paciente. Essa abordagem visa promover um processo mais eficaz e personalizado de treinamento físico.

## 1. Introdução

Neste projeto, exploraremos a eficácia do atendimento remoto em tratamentos fisioterápicos, além de apresentarmos a proposta de desenvolvimento de um software voltado para facilitar a comunicação entre paciente e profissional, visando melhorar a acessibilidade e os resultados dos tratamentos.

### 1.1 Contextualização

A procura por assistência médica domiciliar tem aumentado desde os anos 50, até os dias atuais, para o tratamento fisioterapêutico de pacientes que se encontram em alta hospitalar e aqueles que apresentam limitações de locomoção. Com isso, podemos evidenciar o crescimento de clínicas, hospitais e políticas públicas cada vez mais destinados ao fornecimento e acessibilidade desse tipo de serviço.

Segundo o Censo da Atenção Domiciliar do Núcleo Nacional de Empresas de Serviços de Atenção Domiciliar (NEAD), realizado pela Fundação Instituto de Pesquisas Econômicas (Fipe), referente aos anos de 2021 e 2022, podemos observar um aumento considerável da receita obtida por centros especializados em atendimentos domiciliares, tendo também um crescimento na oferta de trabalhos na área. "Em 2020 com o início da pandemia, a busca pela assistência domiciliar aumentou em 35% [1]".

Recentemente, a pandemia de Covid-19, que resultou no isolamento de uma parcela considerável da população dos grandes centros urbanos, ressaltou ainda mais a relevância da capacitação profissional e da adaptabilidade, tanto por parte dos profissionais da área médica quanto da população em geral, no que diz respeito ao atendimento à distância. Essas habilidades são essenciais para que o atendimento seja conduzido de forma eficaz, tendo impacto em diversas especialidades médicas. 

Antes mesmo da pandemia acontecer, o Sistema do Conselho Federal e Conselhos Regionais de Fisioterapia e Terapia Ocupacional (COFFITO/CREFITOs), já havia elaborado uma cartilha de boas práticas, destinadas ao profissional fisioterapeuta, para que assim o mesmo possa conhecer mais sobre suas responsabilidades quanto ao atendimento domiciliar [2].

O artigo "The effectiveness of telemedicine interventions in physical therapy: A systematic review and meta-analysis" [3], realiza um estudo sistemático sobre a eficácia em tratamentos fisioterápicos realizados por meio do teleatendimento, nele foram observados resultados clínicos positivos quanto a intervenções remotas. A Telemedicina na fisioterapia também se mostrou como uma ferramenta eficaz para melhorar a acessibilidade em serviços de saúde, especialmente aos pacientes que possuem alguma barreira geográfica, ou que possuem alguma limitação, seja ela física ou socioeconômica. 

Uma característica importante relacionada ao tratamento de dados do paciente, seria o monitoramento e o feedback constante realizado pelo profissional em teleatendimentos, essa modalidade de atendimento permite o monitoramento do progresso do paciente, resultando em uma percepção mais eficiente de potenciais problemas, e em ajustes mais rápidos no plano de tratamento, se necessário. 

Com isso, podemos perceber que o desenvolvimento de práticas cada vez mais associadas às tecnologias atuais nos permite simplificar atividades e até mesmo otimizar todo processo de tratamento de um paciente. É importante, também, que o profissional forneça o acompanhamento de forma presencial em determinados momentos, e no caso do atendimento à distância, que sejam observadas as inadequações quanto ao uso de dispositivos eletrônicos e acesso à internet.

### 1.2 Problema

Atualmente vemos uma crescente necessidade de plataformas que possibilitam o acesso de conteúdo fitness, promovendo saúde física, para usuários em condições de difícil acesso aos grandes centros urbanos, onde a grande maioria destes serviços estão localizados. Seja por dificuldades de locomoção, localização ou qualquer outro motivo que possa incapacitar o indivíduo de se locomover ao centro fitness, muitos encontram-se completamente distanciados destes serviços, necessitando urgentemente de um atendimento ou
acompanhamento por dores ou demais consequências dessas moléstias.
De acordo com a Organização Mundial da Saúde (OMS), cerca de 1,71 bilhão de indivíduos sofrem de doenças de origem musculoesqueléticas, sendo ocasionadas em sua grande maioria pela falta de acompanhamento de fortalecimento muscular ou de acompanhamento postural por um profissional da área. Dores como essa podem gerar grande incapacidade no usuário, tornando difícil até as tarefas mais triviais do dia a dia como sentar ou caminhar. Ainda assim, o acesso a tais tratamentos adequados é limitado, especialmente em áreas remotas e em desenvolvimento distantes dos grandes centros urbanos no Brasil, onde a densidade de profissionais de saúde, incluindo fisioterapeutas, pode ser extremamente baixa, dados do IBGE de 2023 suportam está afirmativa..


### 1.3 Objetivo geral

Desenvolver um aplicativo que sirva como uma ferramenta para fisioterapeutas e pacientes, facilitando o planejamento, acompanhamento e avaliação de programas de exercícios terapêuticos.

#### 1.3.1 Objetivos específicos

1.Elaborar uma interface que permita aos fisioterapeutas criar planos de exercícios personalizados, os quais serão submetidos à aprovação dos pacientes através do aplicativo.

2.Desenvolver um sistema de checklist integrado ao aplicativo, onde os pacientes poderão marcar cada exercício realizado, fornecendo um registro detalhado do progresso do tratamento.

3.Implementar questionários em forma de formulários no aplicativo, a serem respondidos pelos pacientes após uma semana de tratamento, com o objetivo de medir a eficácia dos exercícios e a evolução do quadro clínico.

4.Incorporar funcionalidades que permitam aos pacientes enviar comentários e dúvidas diretamente aos fisioterapeutas através dos formulários de avaliação, promovendo uma comunicação eficiente e contínua durante o tratamento.

5.Avaliar a eficácia e satisfação dos usuários com os planos de exercício através de feedbacks, com o objetivo de aprimorar constantemente a eficácia do tratamento fisioterapêutico.

### 1.4 Justificativas

Aumento da Qualidade do Atendimento: Ao oferecer um sistema que permite aos profissionais montar fichas de exercícios detalhadas e personalizadas para cada paciente, acompanhá-los de forma mais precisa, responder dúvidas e fornecer feedback, o sistema contribuirá para um aumento da qualidade do atendimento. Isso se traduzirá em tratamentos mais eficazes e resultados mais satisfatórios para os pacientes.

Facilitação da Comunicação: O sistema proposto facilitará a comunicação entre os profissionais de fisioterapia e seus pacientes. Por meio da possibilidade de os pacientes enviarem dúvidas sobre os exercícios ou a lista de exercícios diretamente pelo sistema, haverá uma comunicação mais fluida e eficiente, permitindo esclarecimentos rápidos e precisos.

Acompanhamento Contínuo: Com a automatização do processo de acompanhamento, os profissionais poderão monitorar de forma contínua e sistemática o cumprimento das fichas de exercícios pelos pacientes. Isso possibilitará identificar precocemente eventuais dificuldades ou desvios no tratamento, permitindo ajustes e intervenções adequadas. 

## 2. Participantes do processo

O público-alvo desse software inclui tanto profissionais de saúde quanto pacientes que buscam serviços de fisioterapia remota e desejam facilitar a comunicação e o acompanhamento do tratamento.

### Profissional licenciado

**Função**
- Profissional prestador de serviço.

**Perfil demográfico**
- Fisioterapeutas licenciados que desejam oferecer serviços de fisioterapia remota aos seus pacientes.
- Profissionais de saúde interessados em fornecer serviços de reabilitação remota, como médicos, enfermeiros ou assistentes sociais.
 
**Atividades**
- Criar e explicar a ficha de exercícios para o paciente.
- Analisar o feedback do paciente sobre os exercícios propostos.
- Acompanhar o progresso do paciente e fornecer feedback.
- Responder às dúvidas do paciente sobre os exercícios.
- Dar feedback final sobre o desempenho do paciente.

**História de usuário**

Como profissional de saúde, reconheço a importância de adaptar meus métodos de tratamento às necessidades individuais dos meus pacientes.
Estou à procura de um software para conduzir sessões de fisioterapia remotas, fornecendo aos meus pacientes orientações personalizadas, exercícios específicos e monitoramento contínuo de seu progresso ao longo do tempo e estou confiante de que o software proposto será uma ferramenta valiosa para aprimorar a qualidade e a eficácia do tratamento que ofereço aos meus pacientes.

### Paciente 

**Função**
- Cliente consumidor final.

**Perfil demográfico**
- Pacientes que estão se recuperando de lesões, cirurgias ou condições médicas que exigem fisioterapia.
- Pacientes que têm dificuldade de locomoção e preferem receber tratamento em casa.
- Pacientes que têm agendas ocupadas e acham conveniente receber tratamento remoto.
- Pacientes que vivem em áreas remotas ou têm dificuldade de acesso a serviços de saúde tradicionais.

**Atividades**

- Analisar e dar feedback sobre a lista de exercícios proposta.
- Seguir a ficha de exercícios conforme prescrita.
- Abrir mensagens de dúvidas sobre os exercícios em caso de dúvida.
- Fornecer feedback sobre o progresso para o profissional.

**História de usuário**

Como paciente em recuperação de uma lesão ortopédica, gostaria de ter acesso a sessões de fisioterapia remotas para que possa dar continuidade ao meu tratamento em casa, especialmente considerando as limitações de locomoção que enfrento no momento.
Eu preciso poder realizar minhas sessões de fisioterapia no conforto da minha própria casa, especialmente considerando as limitações de locomoção que enfrento no momento.


## 3. Modelagem do processo de negócio

### 3.1. Análise da situação atual

Após examinar o contexto atual, percebemos um cenário em que a demanda por assistência médica domiciliar e tratamentos fisioterapêuticos está em alta. Esse aumento na procura é impulsionado por diversos motivos, como a necessidade de atendimento à distância devido à pandemia de Covid-19 e a escassez de serviços de saúde em áreas afastadas e em desenvolvimento.

De acordo com o NEAD (Núcleo Nacional de Empresas de Serviços de Atenção Domiciliar), a busca por cuidados em domicílio aumentou, especialmente desde o início da pandemia, registrando um crescimento de 35% [1]. Além disso, dados do IBGE de 2023 revelam que muitos pacientes enfrentam dificuldades para acessar tratamentos adequados devido à escassez de profissionais de saúde, incluindo fisioterapeutas, em regiões remotas e distantes dos grandes centros urbanos [4].

A análise também evidenciou que a falta de acompanhamento adequado e de acesso a exercícios terapêuticos pode acarretar em problemas musculoesqueléticos e limitações funcionais para os pacientes. A ineficácia na comunicação entre fisioterapeutas e pacientes também é um desafio, tornando difícil acompanhar o progresso do tratamento e responder prontamente às dúvidas e preocupações dos pacientes.

### 3.2. Descrição geral da proposta

A proposta do projeto consiste na criação de um aplicativo móvel destinado a auxiliar fisioterapeutas e pacientes no planejamento, acompanhamento e avaliação de programas de exercícios terapêuticos.

#### Funcionalidades Principais:

1. **Sistema de Checklist:** Os pacientes poderão marcar cada exercício realizado, fornecendo um registro detalhado do progresso do tratamento.

2. **Questionários de Avaliação:** Serão incluídos questionários em formato de formulários, que os pacientes responderão após uma semana de tratamento, para avaliar a eficácia dos exercícios e a evolução do quadro clínico.

3. **Comunicação Eficiente:** Os pacientes poderão enviar dúvidas diretamente aos fisioterapeutas por meio do aplicativo, promovendo uma comunicação eficaz e contínua durante o tratamento.

4. **Avaliação da Eficácia:** Será realizada a avaliação da eficácia e satisfação dos usuários com os planos de exercícios por meio de feedbacks, com o intuito de aprimorar constantemente a eficácia do tratamento fisioterapêutico.

Essas funcionalidades visam simplificar o acompanhamento dos pacientes pelos fisioterapeutas, proporcionando uma experiência mais integrada e eficaz no processo de reabilitação e tratamento físico.

#### Definição do Escopo do Projeto:

O escopo atual do projeto prioriza as funcionalidades essenciais para atender às necessidades imediatas dos fisioterapeutas e pacientes, considerando o tempo de desenvolvimento e os objetivos específicos do aplicativo. As funcionalidades selecionadas foram escolhidas por satisfazer as necessidades imediatas que o projeto busca saciar.

#### Não serão Implementadas:

São campos relevantes a aplicação mas por não caberem no escopo do projeto não entraram no mesmo:

1. **Página de Chat em Tempo Real entre Profissional - Paciente:** Motivo: Embora seja uma ideia viável, a decisão de não implementá-la é devido a restrições de tempo e recursos..
   
2. **Notificações Personalizadas e Lembretes:** Motivo: Não será implementada devido à complexidade de desenvolvimentoe a falta de recursos.

3. **Mapa de Desempenho:** Motivo: Não será implementado devido a restrições de tempo e a complexidade de desenvolvimento.

4. **Busca de Profissionais na Área:** Motivo: Embora seja útil para os pacientes encontrar profissionais de saúde próximos, não se encaixa nesta fase inicial do projeto.

5. **Marcar Consultas com o Profissional:** Motivo: Embora seja uma funcionalidade útil, não é possivel implementar inicialmente devido à complexidade de integração com agendas dos profissionais e preferências individuais de agendamento.

### 3.3. Modelagem dos processos

[PROCESSO 1 - Composicao da Ficha](processo-1-composicao-da-ficha.md "Detalhamento do Processo 1.")

[PROCESSO 2 - Acompanhamento de Exercícios](processo-2-acompanhamento-de-exercicios.md "Detalhamento do Processo 2.")

[PROCESSO 3 - Ajuda](processo-3-ajuda.md "Detalhamento do Processo 3.")

[PROCESSO 4 - Avaliação Final](processo-4-avaliacao-final.md "Detalhamento do Processo 4.")

## 4. Projeto da solução

O documento a seguir apresenta o detalhamento do projeto da solução. São apresentadas duas seções que descrevem, respectivamente: modelo relacional e tecnologias.

[Projeto da solução](solution-design.md "Detalhamento do projeto da solução: modelo relacional e tecnologias.")


## 5. Indicadores de desempenho

O documento a seguir apresenta os indicadores de desempenho dos processos.

[Indicadores de desempenho dos processos](performance-indicators.md)


## 6. Interface do sistema

A sessão a seguir apresenta a descrição do produto de software desenvolvido. 

[Documentação da interface do sistema](interface.md)

## 7. Conclusão

Durante todo o desenvolvimento deste projeto, adquirimos valiosas lições sobre a complexidade dos desafios enfrentados pela sociedade na busca por uma prática de exercícios físicos eficaz e supervisionada. A conscientização da disparidade entre o interesse em manter uma vida ativa e saudável e a qualidade questionável das orientações disponíveis motivou nosso compromisso em criar o Mobilis. Esse projeto vai além de uma solução técnica, tornando-se uma resposta socialmente relevante.

A interação com fisioterapeutas e a compreensão das necessidades dos pacientes nos mostraram a importância de uma abordagem inclusiva e acessível. O Mobilis não se limita a oferecer um serviço; ele representa uma ponte entre o desejo de uma vida mais ativa e saudável e o acesso facilitado a especialistas que podem orientar de maneira personalizada. Além disso, destacamos as parcerias com academias e centros de reabilitação, promovendo escolhas de atividades físicas adequadas e integrando-se às comunidades locais, ampliando o alcance e a relevância do projeto.

Por fim, o Mobilis não é apenas uma inovação técnica, mas também uma expressão do nosso compromisso em contribuir para uma sociedade mais saudável, informada e conectada. O aprendizado adquirido nesse processo vai além do desenvolvimento de um software; ele abrange uma compreensão mais profunda de como a tecnologia pode ser uma força positiva para transformar a qualidade de vida das pessoas. Este projeto, alinhado com princípios éticos e sociais, representa uma promessa de contribuir para o bem-estar duradouro da sociedade.

# REFERÊNCIAS

[1] [Demanda de atendimento domiciliar está em crescente no Brasil](https://www.neadsaude.org.br/2023/10/23/demanda-de-atendimento-domiciliar-esta-em-crescente-no-brasil/) - NÚCLEO NACIONAL DE EMPRESAS DE SERVIÇOS DE ATENÇÃO DOMICILIAR (Brasil). In: Demanda de atendimento domiciliar está em crescente no Brasil. [S. l.], 23 out. 2023. Acesso em: 21 fev. 2024.

[2] [Cartilha do Fisioterapeuta Domiciliar](https://www.coffito.gov.br/nsite/wp-content/uploads/2023/12/cartilha-finalizada-vol-1-1.pdf) - SISTEMA DO CONSELHO FEDERAL E CONSELHOS REGIONAIS DE FISIOTERAPIA E TERAPIA OCUPACIONAL (Brasil). In: DEMANDA de atendimento domiciliar está em crescente no Brasil. [S. l.: s. n.], 2023. Acesso em: 21 fev. 2024.

[3] [Effectiveness of Telerehabilitation in Physical Therapy: A Rapid Overview](https://academic.oup.com/ptj/article/101/6/pzab053/6131423?login=false#392483474) - SERON, Pamela et al. Physical Therapy & Rehabilitation Journal, [s. l.], v. 101, ed. 6, 6 jun. 2021. Acesso em: 21 fev. 2024.

[4] Dados do IBGE (Instituto Brasileiro de Geografia e Estatística) de 2023. [Verifique no site oficial do IBGE](https://www.ibge.gov.br/)


# APÊNDICES


_Atualizar os links e adicionar novos links para que a estrutura do código esteja corretamente documentada._


## Apêndice A - Código fonte

[Código do front-end](../src/front) -- repositório do código do front-end

[Código do back-end](../src/back)  -- repositório do código do back-end


## Apêndice B - Apresentação final


[Slides da apresentação final](presentations/)


[Vídeo da apresentação final](video/)






