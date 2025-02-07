### 3.3.3 Processo 3 – Processo de Ajuda

Processo destinado ao esclarecimento de dúvidas ou orientação para realização das atividades propostas na ficha do paciente.

#### Características:

* Esclarecimento de dúvidas: O paciente pode expressar qualquer incerteza ou confusão que tenha em relação a um exercício específico da lista. Isso pode incluir dúvidas sobre a técnica correta de execução, a frequência ou a intensidade recomendada, ou qualquer desconforto ou preocupação que surja durante a realização dos exercícios.
* Avaliação pelo profissional: Ao receber a mensagem do paciente, o profissional se compromete a avaliar a questão levantada de forma cuidadosa e detalhada. Isso pode envolver a revisão da ficha de exercícios do paciente, a pesquisa de informações adicionais, se necessário, e a consideração das circunstâncias individuais do paciente, como histórico médico, condições pré-existentes ou lesões.
* Resposta e orientação: Com base na avaliação da questão do paciente, o profissional fornece uma resposta completa e esclarecedora, oferecendo orientações específicas e práticas para resolver a dúvida ou preocupação levantada. Podendo incluir instruções detalhadas, eventuais modificações, ou recomendações para lidar com desconfortos e dificuldades gerados durante a realização das atividades.

#### Oportunidades de Melhoria:
- Implementar um sistema de categorização das dúvidas para melhor organização e priorização.
- Introduzir um sistema de notificações para alertar os profissionais sobre novas mensagens de dúvida.
- Integrar uma base de conhecimento ou FAQ para respostas rápidas a perguntas comuns.
- Monitorar o tempo de resposta e estabelecer metas para garantir um atendimento eficiente.

#### Modelo do Processo 3 (BPMN):

![Modelo BPMN do Processo de Ajuda](images/processo-3-processo-de-ajuda(2).png "Modelo BPMN do Processo 3 - Ajuda")

#### Detalhamento das Atividades:

---
**Atividade 1: formula dúvida**

| **Campo**          | **Tipo**          | **Restrições**        | **Valor default**  |
| ------------------ | ----------------- | --------------------- | ------------------ |
| Título             | Área de Texto     | Obrigatório           |                    |
| Nome               | Área de Texto     | Obrigatório           |                    |
| Dúvida             | Área de Texto     | Obrigatório           |                    |

| **Comandos**          | **Destino**                | **Tipo**   |
| --------------------- | -------------------------- | ---------- |
| Enviar                | Análise da Dúvida          | Default    |

---
**Atividade 2: Análisa a dúvida do paciente**

| **Campo**         | **Tipo**         | **Restrições**         | **Valor default**  |
| ----------------- | ---------------- | ---------------------- | ------------------ |
| Pesquisar         | Área de Texto    |                        |                    |
| Avaliação da resposta | Área de Texto | Não editável          |                    |
| Título            | Área de Texto    | Não editável           |                    |
| Nome              | Área de Texto    | Não editável           |                    |
| Dúvida            | Área de Texto    | Não editável           |                    |

| **Comandos**          | **Destino**                   | **Tipo**   |
| --------------------- | ----------------------------- | ---------- |
| Ver dúvida            | Visualizar dúvida selecionada | Default    |
| Pesquisa              | Pesquisar dúvida pelo nome    | Default    |

---
**Atividade 3: Elabora uma resposta**

| **Campo**         | **Tipo**         | **Restrições**         | **Valor default**  |
| ----------------- | ---------------- | ---------------------- | ------------------ |
| Título            | Área de Texto    | Não editável           |                    |
| Nome              | Área de Texto    | Não editável           |                    |
| Dúvida            | Área de Texto    | Não editável           |                    |
| Resposta          | Área de Texto    | Máximo de caracteres   |                    |

| **Comandos**          | **Destino**                   | **Tipo**   |
| --------------------- | ----------------------------- | ---------- |
| Enviar                | Salva resposta na aplicação   | Default    |
| Ver dúvida            | Visualizar dúvida selecionada | Default    |
| Pesquisa              | Pesquisar dúvida pelo nome    | Default    |



---
**Atividade 4: Visualiza resposta**

| **Campo**              | **Tipo**          | **Restrições**        | **Valor default**  |
| ---------------------- | ----------------- | --------------------- | ------------------ |
| Pesquisar              | Área de texto     | Obrigatório           |                    |
| Título                 | Não editável      | Obrigatório           |                    |
| Dúvida                 | Não editável      | Obrigatório           |                    |
| Resposta profissional  | Não editável      | Obrigatório           |                    |
| Avaliação da resposta  | Seleção           | Obrigatório           |                    |

| **Comandos**          | **Destino**                              | **Tipo** |
| --------------------- | ---------------------------------------- | -------- |
| Ver dúvida            | Visualizar dúvida selecionada            | Default  |

Este é o modelo BPMN do processo de ajuda, detalhando as atividades e suas propriedades relacionadas.
